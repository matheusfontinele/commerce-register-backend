package com.cabal.challenge.resource;

import com.cabal.challenge.model.Commerce;
import com.cabal.challenge.repository.CommerceRepository;
import com.cabal.challenge.service.AddressService;
import com.cabal.challenge.service.EmailService;
import com.cabal.challenge.service.PhoneNumberService;
import com.google.common.annotations.VisibleForTesting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/commerces")
public class CommerceResource {

	private final AddressService     addressService;
	private final EmailService       emailService;
	private final PhoneNumberService phoneNumberService;

	private CommerceRepository       commerceRepository;

	public CommerceResource(final AddressService addressService, final EmailService emailService,
	                        final PhoneNumberService phoneNumberService,
	                        final CommerceRepository commerceRepository) {
		this.addressService     = addressService;
		this.emailService       = emailService;
		this.phoneNumberService = phoneNumberService;
		this.commerceRepository = commerceRepository;
	}

	@GetMapping
	public List<Commerce> listAll() {

		List<Commerce> commerceList = commerceRepository.findAll();

		commerceList = commerceList.stream()
		                           .map(getCategoryObjectFunction())
		                           .collect(Collectors.toList());

		return commerceList;
	}

	@VisibleForTesting
	Function<Commerce, Commerce> getCategoryObjectFunction() {
		return commerce -> {
			final Long commerceId = commerce.getId();

			commerce.setPhoneNumbers(phoneNumberService.findByCommerce(commerceId).getContent());
			commerce.setEmails(emailService.findByCommerce(commerceId).getContent());
			commerce.setAddress(addressService.findByCommerce(commerceId));

			return commerce;
		};
	}

}
