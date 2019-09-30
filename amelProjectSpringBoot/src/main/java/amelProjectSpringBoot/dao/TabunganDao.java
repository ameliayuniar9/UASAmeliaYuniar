package amelProjectSpringBoot.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amelProjectSpringBoot.model.Tabungan;
import amelProjectSpringBoot.repository.TabunganRepository;

@Service
public class TabunganDao {
	
	@Autowired
	TabunganRepository tabunganRepository;
	
	public List<Tabungan> readAll(){
		return tabunganRepository.findAll();
	}
	
	public Tabungan readById(Long id) {
		return tabunganRepository.findOne(id);
	}
	
	public List<Tabungan> readByNik(String nik) {
		return tabunganRepository.findTabunganByNik(nik);
	}
	
	public Tabungan readFindSaldo(String nik) {
		return tabunganRepository.findSaldoTabungan(nik);
	}
	
	public Tabungan create(Tabungan tabungan) {
		Tabungan tabmo=tabunganRepository.findSaldoTabungan(tabungan.getNik());
		if(tabmo==null) {
			tabungan.setSaldo(0+tabungan.getKredit()-tabungan.getDebet());
			return tabunganRepository.save(tabungan);
		}else {
			tabungan.setSaldo(tabmo.getSaldo()+tabungan.getKredit()-tabungan.getDebet());
			return tabunganRepository.save(tabungan);
		}
	}
	
	public void delete(Long id) {
		Tabungan tab=tabunganRepository.findOne(id);
		List<Tabungan> dList=tabunganRepository.findTabunganByNik(tab.getNik());
		for(Tabungan dt : dList) {
			if(dt.getId() > id) {
				Tabungan tam1=tabunganRepository.findOne(dt.getId());
				tam1.setSaldo(tam1.getSaldo()-tab.getKredit()+tab.getDebet());
				tabunganRepository.save(tam1);
			}
		}
		tabunganRepository.delete(id);
	}
	
	public Tabungan update(Tabungan tabungan) {
		Tabungan tamSaldo=tabunganRepository.findOne(tabungan.getId());
		tamSaldo.setSaldo(tamSaldo.getSaldo()+tabungan.getKredit()-tabungan.getDebet());
		tamSaldo.setDebet(tabungan.getDebet());
		tamSaldo.setKredit(tabungan.getKredit());
		int tam=tamSaldo.getSaldo();
		List<Tabungan> dataList=tabunganRepository.findTabunganByNik(tabungan.getNik());
		for(Tabungan dt : dataList) {
			if(dt.getId() > tabungan.getId()) {
				Tabungan tam1=tabunganRepository.findOne(dt.getId());
				tam1.setSaldo(tam+tam1.getKredit()-tam1.getDebet());
				tabunganRepository.save(tam1);
				tam=tam1.getSaldo();
			}
		}
		return tabunganRepository.save(tamSaldo);
	}
	
}
