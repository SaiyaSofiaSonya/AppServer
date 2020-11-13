package ru.grigoreva.springserver.controllers;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.grigoreva.springserver.Request;
import ru.grigoreva.springserver.Response;
import ru.grigoreva.springserver.dao.ClientResponseDAO;
;



@Controller
@RequestMapping("/api")
public class ClientMessageExchangeController {

    static Logger logger = Logger.getLogger(ClientMessageExchangeController.class.getName());


    private final ClientResponseDAO clientResponseDAO;

    @Autowired
    public ClientMessageExchangeController(ClientResponseDAO clientResponseDAO) {
        this.clientResponseDAO = clientResponseDAO;
    }

    @GetMapping("/getcheck")  //Возвращает страницу new.html  пользователю при переходе /userinfo/new, метод get
    public String newCheck() { //В контроллер внедряется модель данных User
        return "api/getcheck";
    }


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
            "application/vnd.example.todo_payload+json"})
    @ResponseBody
    public Response receiveMessages(@RequestBody Request request) {
        logger.info("Принято сообщение от клиента "
                + request.getUser().getName()
                + " " + request.getUser().getSurname() + ": "
                + request.getMessage().getBody() + ": "
                + request.getMessage().getTimestamp());

        return new Response(clientResponseDAO.getResponseMessage(request)); //передали json  ответе


    }

}

