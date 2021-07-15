package com.example.graphql;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {

	public Post getRecentPosts(String id) {

		return new Post(id, "TitleA", "categoryA", "authorA");
	}

}