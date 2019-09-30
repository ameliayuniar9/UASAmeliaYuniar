package amelProjectSpringBoot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import amelProjectSpringBoot.dao.TabunganDao;
import amelProjectSpringBoot.model.Tabungan;

@RestController
@RequestMapping("/bank")
public class TabunganController {
	
	@Autowired
	TabunganDao tabunganDao;
	
	@PostMapping("/createTabungan")
	public Tabungan create(@Valid @RequestBody Tabungan tabungan) {
		return tabunganDao.create(tabungan);
	}
	
	@GetMapping("/AllTabungan")
	public List<Tabungan> readAll(){
		return tabunganDao.readAll();
	}
	
	@GetMapping("/TabunganById/{id}")
	public ResponseEntity<Tabungan> readById(@PathVariable(value="id") Long id) {
		Tabungan tab = tabunganDao.readById(id);
		if(tab==null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().body(tab);
		}
	}
	
	@GetMapping("/TabunganByNik/{nik}")
	public List<Tabungan> readByNik(@PathVariable(value="nik") String nik) {
		return tabunganDao.readByNik(nik);
	}
	
	@PutMapping("/updateTabungan/{id}")
	public ResponseEntity<Tabungan> update(@PathVariable(value="id") Long id, @Valid @RequestBody Tabungan tabungan){
		Tabungan tab = tabunganDao.readById(id);
		if(tab==null) {
			return ResponseEntity.notFound().build();
		}else {
			tab.setSaldo(tab.getSaldo()-tab.getKredit()+tab.getDebet());
			tab.setKredit(tabungan.getKredit());
			tab.setDebet(tabungan.getDebet());
			
			Tabungan tabResult = tabunganDao.update(tab);
			return ResponseEntity.ok().body(tabResult);
		}
	
	}
	
	@DeleteMapping("/deleteTabungan/{id}")
	public ResponseEntity<Tabungan> delete(@PathVariable(value="id") Long id){
		Tabungan tab = tabunganDao.readById(id);
		if(tab==null) {
			return ResponseEntity.notFound().build();
		}else {
			tabunganDao.delete(id);
			return ResponseEntity.ok().build();
		}
	}
}
