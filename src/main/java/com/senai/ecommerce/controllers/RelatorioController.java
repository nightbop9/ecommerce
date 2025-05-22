package com.senai.ecommerce.controllers;

import com.senai.ecommerce.services.RelatorioService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("relatorio")
public class RelatorioController {

    private final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping("/gerar")
    public ResponseEntity<String> gerarRelatorioPDF(@RequestParam String caminho) throws JRException {
        relatorioService.gerarRelatorio(caminho);
        return ResponseEntity.ok("Relatório gerado." + caminho);
    }
}
