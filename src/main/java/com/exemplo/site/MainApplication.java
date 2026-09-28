package com.exemplo.site;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Aplicação principal - Site Profissional
 * Integra: Login, Cadastro de Pessoas, Pagamentos (Mercado Pago)
 * 
 * @author Desenvolvedor
 * @version 1.0.0
 */
@SpringBootApplication
public class MainApplication {

    private static final Logger logger = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        logger.info("=".repeat(60));
        logger.info("✅ APLICAÇÃO INICIADA COM SUCESSO");
        logger.info("🌐 Acesse em: http://localhost:8080/login");
        logger.info("👤 Usuário: admin");
        logger.info("🔑 Senha: Admin@12345");
        logger.info("=".repeat(60));
    }
}
