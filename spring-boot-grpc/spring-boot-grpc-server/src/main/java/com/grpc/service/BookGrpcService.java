package com.grpc.service;

import grpc.api.BookList;
import grpc.api.BookServiceGrpc;
import com.grpc.utils.BookUtil;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
@GrpcService(BookServiceGrpc.class)
public class BookGrpcService extends BookServiceGrpc.BookServiceImplBase {

    private Logger logger = LoggerFactory.getLogger(BookGrpcService.class);

    @Override
    public void createBooks(BookList request, StreamObserver<BookList> responseObserver) {
        log.info("Request " + request);

        BookList.Builder responseBuilder = BookList.newBuilder();

        BookUtil.assignISBN(request.getBookList()).forEach(responseBuilder::addBook);

        BookList bookListResponse = responseBuilder.build();

        log.info("Response " + bookListResponse);

        responseObserver.onNext(bookListResponse);
        responseObserver.onCompleted();
    }

}
