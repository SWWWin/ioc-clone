package com.ll.framework.ioc;

import com.ll.domain.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.service.TestPostService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestFacadePostService {
    private final TestPostService testPostService;
    private final TestPostRepository testPostRepository;
}
