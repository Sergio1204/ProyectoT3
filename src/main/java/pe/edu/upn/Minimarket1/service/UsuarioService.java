package pe.edu.upn.Minimarket1.service;

import java.util.Optional;

import pe.edu.upn.Minimarket1.model.entity.Usuario;

public interface UsuarioService extends CrudService<Usuario, Long> {
	Optional<Usuario> findByUsername(String username) throws Exception;
}
