package pe.edu.upn.Minimarket1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.Minimarket1.model.entity.Venta;
import pe.edu.upn.Minimarket1.model.repository.VentaRepository;
import pe.edu.upn.Minimarket1.service.VentaService;

@Service
public class VentaServiceImpl implements VentaService{
	@Autowired
	private VentaRepository transaccionRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Venta> findAll() throws Exception {
		return transaccionRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Venta> findById(Integer id) throws Exception {
		return transaccionRepository.findById(id);
	}

	@Transactional
	@Override
	public Venta save(Venta entity) throws Exception {
		return transaccionRepository.save(entity);
	}

	@Transactional
	@Override
	public Venta update(Venta entity) throws Exception {
		return transaccionRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		transaccionRepository.deleteById(id);
	}
	
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		transaccionRepository.deleteAll();
	}
}
