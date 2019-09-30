package amelProjectSpringBoot.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="tabungan_tbl")
@EntityListeners(AuditingEntityListener.class)
public class Tabungan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotBlank
	private String nik;
	
	@NotBlank
	private String nama;
	
	private int kredit;
	
	private int debet;
	
	private int saldo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date createtime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public int getKredit() {
		return kredit;
	}

	public void setKredit(int kredit) {
		this.kredit = kredit;
	}

	public int getDebet() {
		return debet;
	}

	public void setDebet(int debet) {
		this.debet = debet;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	
	
	
}
