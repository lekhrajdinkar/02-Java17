package web.config.Pcourse;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
//import javax.servlet.*;
import jakarta.servlet.*;
import java.io.IOException;

@Configuration
public class AppInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //ServletRegistration.Dynamic reg = servletContext.addServlet("download", new DownloadServlet());
        //reg.addMapping("/download");
    }
}

class DownloadServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
