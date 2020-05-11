package fr.didier.giveapp.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "L'objet n'existe pas")
public class NotFoundException extends Exception{}
