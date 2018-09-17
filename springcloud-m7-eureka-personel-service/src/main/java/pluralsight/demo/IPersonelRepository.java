package pluralsight.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IPersonelRepository extends PagingAndSortingRepository<Personel,Integer> {

	void deleteById(Long id);
	
	Personel findById(Long id);
	
	List<Personel> findByName(String email);

	List<Personel> findByEmail(String email);
	
	@Query(
			value = "SELECT * FROM Personel",
			countQuery = "SELECT count(*) FROM Personel",
			nativeQuery = true)
	Page<Personel> findAllUsersWithPagination(Pageable pageable);
	

	@Query(value = "SELECT * FROM Personel p WHERE"
			+ "(:name is null or p.name = :name) and "
			+ "(:email is null or p.email = :email)",
			countQuery = "SELECT count(*) FROM Personel",
			nativeQuery = true)
	Page<Personel> findUserByNameAndEmailNamedParamsNative(
			@Param("email") String email, @Param("name") String name, Pageable pageable);

}
