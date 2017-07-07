package grpc.web;

import grpc.model.Book;
import grpc.service.BookGRpcService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wangliang
 * @since 2017-07-05
 */
@RestController
@Slf4j
@Scope("prototype")
@AllArgsConstructor
public class BookController {

    private BookGRpcService bookGRpcService;

    @RequestMapping(value = "/createBooks", method = RequestMethod.POST)
    @ResponseBody
    public void createBooks(@RequestBody Book request) {
        bookGRpcService.createBooks(request);
    }

}
