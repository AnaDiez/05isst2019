package es.upm.dit.isst.rgpd.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import es.upm.dit.isst.rgpd.dao.EvaluadorDAO;
import es.upm.dit.isst.rgpd.dao.EvaluadorDAOImplementation;
import es.upm.dit.isst.rgpd.dao.InvestigadorDAO;
import es.upm.dit.isst.rgpd.dao.InvestigadorDAOImplementation;
import es.upm.dit.isst.rgpd.model.Investigador;
import es.upm.dit.isst.rgpd.model.Evaluador;


@WebServlet({ "/EvaluadorServlet"})
public class EvaluadorServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		EvaluadorDAO edao = EvaluadorDAOImplementation.getInstance();		
		Evaluador evaluador = edao.read(email);
		req.getSession().setAttribute( "evaluador", evaluador);		
		req.getSession().setAttribute( "evaluaciones_list", evaluador.getEvaluaciones());
		
		getServletContext().getRequestDispatcher("/EvaluadorView.jsp").forward(req,resp);

	}

}
