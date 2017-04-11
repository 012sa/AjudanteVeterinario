package br.edu.ifpb.resteasyapp.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.edu.ifpb.resteasyapp.dao.AnimalDAO;
import br.edu.ifpb.resteasyapp.dao.PesoDAO;
import br.edu.ifpb.resteasyapp.dao.PropriedadeDAO;
import br.edu.ifpb.resteasyapp.entidade.Animal;
import br.edu.ifpb.resteasyapp.entidade.Peso;
import br.edu.ifpb.resteasyapp.entidade.Propriedade;

@Path("peso")
public class PesoController {

	@PermitAll
	@POST
	@Path("/inserir")
	@Consumes("application/json")
	@Produces("application/json")
	public Response insert(Peso peso) {

		// Preparando a resposta. Provisoriamente o sistema preparará a resposta
		// como requisição incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		// TODO: Regra de negócio e manipulação de dados nesse ponto. As
		// informaçãos devem ser associadas
		// nesse ponto ao biuld (response).

		try {
			
			int id_peso = PesoDAO.getInstance().insert(peso);

			peso.setId(id_peso);

			builder.status(Response.Status.CREATED).entity(peso);

		} catch (SQLException e) {

			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		// Resposta.
		return builder.build();
	}

	@PermitAll
	@GET
	@Path("/listar/id_animal/{id_animal}")
	@Produces("application/json")
	public List<Peso> getAll(@PathParam("id_animal") int id_animal) {

		// Retorno em formato de lista.
		// Desse modo o response sempre conterá o código de resposta OK.
		List<Peso> pesos = new ArrayList<Peso>();

		try {

			// TODO: Regra de negócio e manipulação de dados nesse ponto.
			pesos = PesoDAO.getInstance().getAllPesosByAnimal(id_animal);

		} catch (SQLException e) {

			// TODO: Tratar a exceção.
		}

		// Será retornado ao cliente um conjunto de alunos no formato de Json.
		return pesos;
	}
	
	@PermitAll
	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Peso> getAll() {

		// Retorno em formato de lista.
		// Desse modo o response sempre conterá o código de resposta OK.
		List<Peso> pesos = new ArrayList<Peso>();

		try {

			// TODO: Regra de negócio e manipulação de dados nesse ponto.
			pesos = PesoDAO.getInstance().getAll();

		} catch (SQLException e) {

			// TODO: Tratar a exceção.
		}

		// Será retornado ao cliente um conjunto de alunos no formato de Json.
		return pesos;
	}
	
	@PermitAll
	@GET
	@Path("/id/{id}")
	@Produces("application/json")
	public Response getPesoById(@PathParam("id") int id_peso) {

		// Preparando a resposta. Provisoriamente o sistema preparará a resposta
		// como requisição incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {

			// Regra de negócio e manipulação de dados nesse ponto.
			Peso peso = PesoDAO.getInstance().getById(id_peso);

			if (peso != null) {

				// As informaçãos associadas ao build para o response.
				builder.status(Response.Status.OK);
				builder.entity(peso);

			} else {

				// Conteúdo não encontrado.
				builder.status(Response.Status.NOT_FOUND);
			}

		} catch (SQLException exception) {

			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		// Resposta
		return builder.build();
	}
	
	@PermitAll
	@POST
	@Path("/deletar")
	@Consumes("application/json")
	@Produces("application/json")
	public Response delete(Peso peso) {
		
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {

			PesoDAO.getInstance().delete(peso);
			peso = PesoDAO.getInstance().find(peso);
			
			if (peso != null){
				
				builder.status(418); //I'm a teapot
				
			} else {
				
				builder.status(Response.Status.NO_CONTENT).entity(peso);
				
			}

		} catch (SQLException exception) {
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		return builder.build();
	}
	
	@PermitAll
	@POST
	@Path("/alterar")
	@Consumes("application/json")
	@Produces("application/json")
	public Response update(Peso peso) {

		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {

			PesoDAO.getInstance().updateEntity(peso);
			PesoDAO.getInstance().find(peso);
			builder.status(Response.Status.OK).entity(peso);

		} catch (SQLException exception) {
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		return builder.build();
	}

}
