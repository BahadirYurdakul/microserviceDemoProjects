package pluralsight.demo;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class PersonelController {
	private static final int PAGE_SIZE = 10;
	
    @Autowired
    IPersonelRepository personelRepository;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Personel register(@RequestBody Personel personel) {
		if(isPersonelAlreadyExists(personel.getEmail())) {
            throw new IllegalArgumentException("error.duplicateEmail");
		}
		personelRepository.save(personel);
		return personel;
	}
	
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public Page<Personel> searchPersonel(Personel personel,
			@PageableDefault(size=PAGE_SIZE, page=1) Pageable p) {
		
		PageRequest pageable = PageRequest.of(p.getPageNumber(), PAGE_SIZE, p.getSort());
		return personelRepository.findUserByNameAndEmailNamedParamsNative(personel.getEmail(), personel.getName(), pageable);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String searchPersonel(@PathVariable(value="id") Long personelId) {
		personelRepository.deleteById(personelId);
		return "Personel deleted by id: " + personelId;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PATCH)
	@ResponseBody
	public Personel searchPersonel(Personel personelParams) {
		if(personelParams.getId() == null) {
			throw new IllegalArgumentException("error.IdEmpty");
		}
		Personel personelToUpdate = personelRepository.findById(personelParams.getId());
		Personel.mergePersonel(personelToUpdate, personelParams);
		return personelRepository.save(personelToUpdate);
	}
	
	private boolean isPersonelAlreadyExists(String email) {
		return !personelRepository.findByEmail(email).isEmpty();
	}

	@ExceptionHandler
	void handleIllegalArgumentException(
			IllegalArgumentException e,
			HttpServletResponse response) throws IOException {

		System.out.println("IllegalArgumentException occurred: " + e.getMessage());
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}
	
	@ExceptionHandler
	void handleInvalidDataAccessResourceUsageException(
			InvalidDataAccessResourceUsageException e,
			HttpServletResponse response) throws IOException {

		System.out.println("InvalidDataAccessResourceUsageException occurred: " + e.getMessage());
		response.sendError(HttpStatus.BAD_REQUEST.value(), "error.sqlSyntax");
	}
	
	@ExceptionHandler
	void handleException(
			Exception e,
			HttpServletResponse response) throws IOException {

		System.err.println("Exception occurred: " + e.getMessage());
		response.sendError(HttpStatus.BAD_REQUEST.value(), "error.unexpected");
	}
}