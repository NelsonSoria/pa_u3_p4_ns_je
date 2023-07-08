package com.example.demo.respository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.dto.EstudianteDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional 
public class EstudianteRespositoryImpl implements EstudianteRespository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante estu) {
	   this.entityManager.persist(estu);
		
	}

	@Override
	public void eliminar(String cedula) {
		Estudiante estuEncontrado=this.seleccionarPorCD(cedula);
		this.entityManager.remove(estuEncontrado);
		
	}

	@Override
	public Estudiante seleccionarPorCD(String cedula) {
		return this.entityManager.find(Estudiante.class, cedula);//.class para decir con que va a trabajar el metodo
	}

	@Override
	public void actualizar(Estudiante estu) {
		this.entityManager.merge(estu);
	
	}

	@Override
	public Estudiante seleccionarPorApellido(String apellido) {
		
		//SQL
		//SELECT * FROM estudiante e WHERE e.estu_apellido =
		//JPQL
		//SELECT e FROM Estudiante e WHERE e.apllido=
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido= :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> seleccionarListaPorApellido(String apellido) {
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido= :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public Estudiante seleccionarPorApellidoYNombre(String apellido, String nombre) {

		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido= :datoApellido AND e.nombre= :datoNombre");
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoNombre", nombre);
		
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoTyped(String apellido) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido= :datoApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoNamed(String apellido) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscaPorApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoNamedQuery(String apellido) {
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscaPorApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoNativeQuery(String apellido) {
		//SQL PURO
		Query myQuery=this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE estu_apellido=:datoApellido",Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoNativeQueryNamed(String apellido) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorApellidoNative",Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return   myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorNombreNamedQuery(String nombre) {
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscaPorNombre", Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorNombreNativeQueryNamed(String nombre) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombreNative",Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return   myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoCriteriaAPIQuery(String apellido) {
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		//1.Especificar el tipo de retorno que tiene mi Query
		CriteriaQuery<Estudiante> myCriteriAQuery= myBuilder.createQuery(Estudiante.class);
		
		//2.Empezamos a crear el SQL
		//2.1Definimos el FROM (Root)
		Root<Estudiante> miTablaFrom = myCriteriAQuery.from(Estudiante.class);
		
		//3. Construir las condiciones de mi SQL (Predicados)
		//Las condiciones se las conoce como Predicados
		//Cada condicion es un predicado
		//e.apellido=:datoApellido
		Predicate condicionApellido= myBuilder.equal(miTablaFrom.get("apellido"), apellido);
		
		//4.Armamos mi SQL final
		myCriteriAQuery.select(miTablaFrom).where(condicionApellido);
		
		//5.La ejecucion del Query lo realizamos con TypedQuery
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myCriteriAQuery);
		return myQueryFinal.getSingleResult();
	}

	@Override
	public Estudiante seleccionarEstudianteDinamico(String nombre, String apellido, Double peso) {
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myCriteriAQuery= myBuilder.createQuery(Estudiante.class);
		Root<Estudiante> miTablaFrom = myCriteriAQuery.from(Estudiante.class);
		
		//peso>100  e.nombre=? AND e.apelldio=?
		//peso<=100 e.nombre=? or e.apellido=?
		
		//e.nombre=?
		Predicate pNombre= myBuilder.equal(miTablaFrom.get("nombre"), nombre);
		
		//e.apellido=?
		Predicate pApellido=myBuilder.equal(miTablaFrom.get("apellido"), apellido);
		
		Predicate predicadoFinal=null;
		if(peso.compareTo(Double.valueOf(100))<=0) {
			predicadoFinal= myBuilder.or(pNombre,pApellido);
		}else {
			predicadoFinal= myBuilder.and(pNombre,pApellido);
		}
		myCriteriAQuery.select(miTablaFrom).where(predicadoFinal);
		
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myCriteriAQuery);
		return myQueryFinal.getSingleResult();
	}

	@Override
	public int eliminarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		//DELETE FROM estudiante where estu_nombre=?
		//DELETE FROM Estudiante e Where e.nombre=:datoNombre
		Query miQuery = this.entityManager.createQuery("DELETE FROM Estudiante e Where e.nombre=:datoNombre");
		miQuery.setParameter("datoNombre", nombre);
		
		//numero de registros afectados
		return miQuery.executeUpdate();
	}

	@Override
	public int actualizarPorApellido(String nombre,String apellido) {
		//UPDATE estudiante SET estu_nombre=? WHERE estu_apellldo=?
		//UPDATE Estudiante e SET e.nombre=:datoNombre WHERE e.apellido=:datoApellido
		Query miQuery = this.entityManager.createQuery("UPDATE Estudiante e SET e.nombre=:datoNombre WHERE e.apellido=:datoApellido");
		miQuery.setParameter("datoNombre",nombre);
		miQuery.setParameter("datoApellido", apellido);
	    return	miQuery.executeUpdate();
	}

	@Override
	public List<EstudianteDTO> seleccionarTodosDTO() {
		TypedQuery<EstudianteDTO> myQuery=this.entityManager.createQuery("SELECT NEW com.example.demo.repository.modelo.dto.EstudianteDTO(e.nombre,e.apellido) FROM Estudiante e ",EstudianteDTO.class);
				
		return myQuery.getResultList();
	}

}
