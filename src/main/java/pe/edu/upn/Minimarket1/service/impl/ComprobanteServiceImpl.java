package pe.edu.upn.Minimarket1.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.upn.Minimarket1.model.entity.Comprobante;
import pe.edu.upn.Minimarket1.model.repository.ComprobanteRepository;
import pe.edu.upn.Minimarket1.service.ComprobanteService;

public class ComprobanteServiceImpl implements ComprobanteService{
	@Autowired
	private ComprobanteRepository facturaRepository;
	
	@Transactional()
	@Override
	public List<Comprobante> findAll() throws Exception{
		return facturaRepository.findAll();
	}
	
	@Transactional
	@Override
	public Optional<Comprobante> findById(Integer id) throws Exception{
		return facturaRepository.findById(id);
	}
	
	@Transactional
	@Override
	public Comprobante save(Comprobante entity) throws Exception{
		return facturaRepository.save(entity);
	}
	
	@Transactional
	@Override
	public Comprobante update(Comprobante entity) throws Exception{
		return facturaRepository.save(entity);
	}
	
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception{
		facturaRepository.deleteById(id);
	}
	
	@Transactional
	@Override
	public void deleteAll() throws Exception{
		facturaRepository.deleteAll();
	}
}
