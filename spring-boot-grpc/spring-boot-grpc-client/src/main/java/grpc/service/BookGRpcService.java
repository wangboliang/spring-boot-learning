package grpc.service;

import grpc.api.Book;
import grpc.api.BookList;
import grpc.api.BookServiceGrpc.BookServiceBlockingStub;
import grpc.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * rpc层数据传输
 * </p>
 *
 * @author wangliang
 * @since 2017-07-05
 */
@Service
@Slf4j
@AllArgsConstructor
public class BookGRpcService {

    private BookServiceBlockingStub blockingStub;

    public void createBooks(grpc.model.Book request) {
        log.info("createBooks request is:{}", JsonUtil.objectToJson(request));

        Book.Builder bookBuilder = Book.newBuilder();
        bookBuilder.setISBN(request.getISBN() == null ? "" : request.getISBN());
        bookBuilder.setAuthor(request.getAuthor() == null ? "" : request.getAuthor());
        bookBuilder.setTitle(request.getTitle() == null ? "" : request.getTitle());

        BookList.Builder bookListBuilder = BookList.newBuilder();
        bookListBuilder.addBook(bookBuilder);
        BookList gRpcResponse = blockingStub.createBooks(bookListBuilder.build());

        log.info("createBooks response is:{}", gRpcResponse);
    }

}
