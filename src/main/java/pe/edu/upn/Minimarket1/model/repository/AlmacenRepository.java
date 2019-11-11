package pe.edu.upn.Minimarket1.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upn.Minimarket1.model.entity.Almacen;

@Repository
public interface AlmacenRepository extends JpaRepository<Almacen, String>{

}
