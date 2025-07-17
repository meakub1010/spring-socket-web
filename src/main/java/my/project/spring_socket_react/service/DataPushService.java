package my.project.spring_socket_react.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class DataPushService {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Scheduled(initialDelay = 10000, fixedRate = 20000)
    public void pushLiveData(){
        String url = "https://api.twelvedata.com/time_series?start_date=2020-05-06&outputsize=5&symbol=aapl&interval=1day&apikey=d2c28e6a0a384f558c1c333ae4f902fb";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> data = restTemplate.getForObject(url, Map.class);
        messagingTemplate.convertAndSend("/topic/notification", data.toString());
        System.out.println("data publishing");
    }
}

