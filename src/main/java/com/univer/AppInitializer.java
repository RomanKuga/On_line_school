package com.univer;

//public class AppInitializer implements WebApplicationInitializer {
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext webApplicationContext =
//                new AnnotationConfigWebApplicationContext();
//
//        webApplicationContext.register(AppConfig.class);
//
//        servletContext.addListener(new ContextLoaderListener(webApplicationContext));
//
//        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
//        ServletRegistration.Dynamic registration = servletContext
//                .addServlet("dispatcher", dispatcherServlet);
//
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/");
//
//    }
//}
