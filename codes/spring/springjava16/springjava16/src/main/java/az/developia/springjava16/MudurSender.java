package az.developia.springjava16;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile(value = "production")
@Component
public class MudurSender implements MessageSender {
	@Override
	public void send(String message) {
		System.out.println("bunu mudure gonder");
	}
}
