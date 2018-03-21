<?xml version="1.0" encoding="utf-8"?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<friends>
	<c:forEach items="${friends}"  var="user">
		<friend>
		      <id>${user.id}</id>
		      <name>${user.name}</name>
		</friend>
	</c:forEach>
</friends>