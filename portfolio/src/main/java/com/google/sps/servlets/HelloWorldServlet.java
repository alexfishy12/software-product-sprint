package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/json;");
    ArrayList<String> commentArray = new ArrayList<>();
    //comments
    commentArray.add("I spend a lot of my free time playing League of Legends!");
    commentArray.add("When I like a song a lot, I learn it on guitar.");
    commentArray.add("I want to create a 2D soulslike game, because I really enjoy the Dark Souls series.");
    commentArray.add("Interstellar is my favorite movie!");
    commentArray.add("Some of my favorite shows are: Breaking Bad, Ozark, and Community.");

    String json = convertToJsonUsingGson(commentArray);
    response.getWriter().println(json);
  }

  private static String convertToJsonUsingGson(ArrayList<String> comments) {
    Gson gson = new Gson();
    String json = gson.toJson(comments);
    return json;
  }
}
