package pe.edu.upn.Minimarket1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.Minimarket1.model.entity.DetallePedido;
import pe.edu.upn.Minimarket1.model.repository.DetallePedidoRepository;
import pe.edu.upn.Minimarket1.service.DetallePedidoService;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService{
	
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<DetallePedido> findAll() throws Exception {
		// TODO Auto-generated method stub
		return detallePedidoRepository.findAll();
	}

	@Override
	public Optional<DetallePedido> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return detallePedidoRepository.findById(id);
	}

	@Override
	public DetallePedido save(DetallePedido entity) throws Exception {
		// TODO Auto-generated method stub
		return detallePedidoRepository.save(entity);
	}

	@Override
	public DetallePedido update(DetallePedido entity) throws Exception {
		// TODO Auto-generated method stub
		return detallePedidoRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		detallePedidoRepository.deleteById(id);
		
	}

	@Override
	public void deleteAll() throws Exception {
		detallePedidoRepository.deleteAll();
		
	}

}
