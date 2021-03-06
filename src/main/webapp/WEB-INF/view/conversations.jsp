<%--
  Copyright 2017 Google Inc.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
--%>
<%@ page import="java.util.List" %>
<%@ page import="codeu.model.data.Conversation" %>
<%@ page import="codeu.model.data.User" %>
<%@ page import = "codeu.model.store.basic.UserStore" %>

<!DOCTYPE html>
<html>
<head>
  <title>Conversations</title>
  <link rel="stylesheet" href="/css/main.css">
</head>
<body>
  <%@ include file = "navbar.jsp" %>
  <div id="container">

    <% if(request.getAttribute("error") != null){ %>
        <h2 style="color:red"><%= request.getAttribute("error") %></h2>
    <% } %>

    <% if(request.getSession().getAttribute("user") != null){ %>
      <h1>New Conversation</h1>
      <form action="/conversations" method="POST">
          <div class="form-group">
            <label class="form-control-label">Title:</label>
          <input type="text" name="conversationTitle">
        </div>

        <button type="submit">Create</button>
      </form>

      <hr/>
    <% } %>

    <h1>Conversations</h1>

    <%
    List<Conversation> conversations =
      (List<Conversation>) request.getAttribute("conversations");
    if(conversations == null || conversations.isEmpty()){
    %>
      <p>Create a conversation to get started.</p>
    <%
    }
    else{
    %>
      <ul class="mdl-list">
    <%
      for(Conversation conversation : conversations){
    %>
      <li><a href="/chat/<%= conversation.getTitle() %>">
        <%= conversation.getTitle() %></a>
        <% String u = (String) request.getSession().getAttribute("user");
        if(u != null){
            boolean check = (boolean) request.getSession().getAttribute("isSuperUser");
            if(check){ %>
            <a href="#"onclick="deleteConversation('<%=conversation.getTitle()%>')">X</a>
        <% }} %>
      </li>
    <%
      }
    %>
      </ul>
    <%
    }
    %>
    <hr/>
  </div>
</body>
</html>
<script>
function deleteConversation(convoTitle) {
  var url = "http://gcu-tnt.appspot.com/conversations?conversation=";
  var xhr = new XMLHttpRequest();
  console.log("Hello");

  xhr.onload = function () {
    if (xhr.readyState != 4 || xhr.status != "200") {
      console.error("Error deleting conversation");
      console.error(xhr.responseText);
    }
  }
  xhr.open("DELETE", url + convoTitle, true);
  xhr.send(null);
  location.reload(true);
}
</script>
