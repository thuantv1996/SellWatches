package j2ee.spring.sellwatches.services;

import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.viewmodel.ContactViewModel;

@Component
public interface ContactService {
	public boolean sendMessage(ContactViewModel contact);
}
