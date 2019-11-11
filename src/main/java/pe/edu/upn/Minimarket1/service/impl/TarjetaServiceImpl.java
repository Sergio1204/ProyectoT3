package pe.edu.upn.Minimarket1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.Minimarket1.model.entity.Tarjeta;
import pe.edu.upn.Minimarket1.model.repository.TarjetaRepository;
import pe.edu.upn.Minimarket1.service.TarjetaService;

@Service
public class TarjetaServiceImpl implements TarjetaService{
	
	@Autowired
	TarjetaRepository tarjetaRepositoy;
	
	@Transactional(readOnly = true)
	@Override
	public List<Tarjeta> findAll() throws Exception {
		// TODO Auto-generated method stub
		return tarjetaRepositoy.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Tarjeta> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return tarjetaRepositoy.findById(id);
	}

	@Override
	public Tarjeta save(Tarjeta entity) throws Exception {
		// TODO Auto-generated method stub
		return tarjetaRepositoy.save(entity);
	}

	@Override
	public Tarjeta update(Tarjeta entity) throws Exception {
		// TODO Auto-generated method stub
		return tarjetaRepositoy.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		tarjetaRepositoy.deleteById(id);
		
	}

	@Override
	public void deleteAll() throws Exception {
		tarjetaRepositoy.deleteAll();
	}

}
