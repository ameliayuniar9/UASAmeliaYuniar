package amelProjectSpringBoot.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import amelProjectSpringBoot.model.Tabungan;

public interface TabunganRepository extends JpaRepository<Tabungan, Long> {
	@Query(value = "SELECT * FROM tabungan_tbl WHERE nik=:nik", nativeQuery=true)
	List<Tabungan> findTabunganByNik(@Param("nik") String nik);
	
	@Query(value="SELECT * FROM tabungan_tbl WHERE nik=:nik ORDER BY id DESC LIMIT 1", nativeQuery=true)
	Tabungan findSaldoTabungan(@Param("nik") String nik);
}
