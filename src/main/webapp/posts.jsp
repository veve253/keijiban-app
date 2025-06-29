<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="model.User" %>
<%@ page import="model.Post" %>
<%@ page import="java.util.List" %>

<%
    User user = (User) request.getAttribute("user");
    List<Post> posts = (List<Post>) request.getAttribute("posts");
%>

<h2>ようこそ、<%= user.getUsername() %> さん</h2>
<h3>投稿一覧</h3>

<ul>
<% for (Post post : posts) { 
       boolean isOwnPost = post.getUserId() == user.getUserId();
%>
    <li>
        <strong><%= post.getUserName() %></strong>：
        <span class="content"><%= post.getContent() %></span>（<%= post.getCreatedAt() %>）

        <% if (isOwnPost) { %>
            <button onclick="editPost(<%= post.getId() %>, '<%= post.getContent().replace("'", "\\'") %>')">編集</button>
            <button onclick="confirmDelete(<%= post.getId() %>)">削除</button>
        <% } %>
    </li>
<% } %>
</ul>

<form method="post" action="<%= request.getContextPath() %>/post/create">
    <label for="content">投稿内容：</label>
    <input type="text" id="content" name="content" required>
    <input type="submit" value="投稿">
</form>

<p><a href="<%= request.getContextPath() %>/user/logout">ログアウト</a></p>

<form id="editForm" method="post" action="<%= request.getContextPath() %>/post/update" style="display:none;">
    <input type="hidden" name="id" id="editPostId">
    <input type="hidden" name="content" id="editContent">
</form>

<form id="deleteForm" method="post" action="<%= request.getContextPath() %>/post/delete" style="display:none;">
    <input type="hidden" name="id" id="deletePostId">
</form>

<script>
function editPost(id, oldContent) {
    const newContent = prompt("投稿を編集:", oldContent);
    if (newContent !== null && newContent.trim() !== "") {
        document.getElementById("editPostId").value = id;
        document.getElementById("editContent").value = newContent;
        document.getElementById("editForm").submit();
    }
}

function confirmDelete(id) {
    if (confirm("本当に削除しますか？")) {
        document.getElementById("deletePostId").value = id;
        document.getElementById("deleteForm").submit();
    }
}
</script>
