package com.senai.ecommerce.services;

import com.senai.ecommerce.dto.RelatorioPedidoDTO;
import com.senai.ecommerce.entities.Pedido;
import com.senai.ecommerce.repositories.PedidoRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Serviço responsável pela geração de relatórios de pedidos.
 * Utiliza a biblioteca JasperReports para criação de documentos PDF.
 */
@Service
public class RelatorioService {
    /**
     * Repositório de pedidos para acesso aos dados.
     */
    @Autowired
    PedidoRepository pedidoRepository;

    /**
     * Gera um relatório de pedidos em formato PDF.
     *
     * Este método busca todos os pedidos do banco de dados,
     * converte para DTOs apropriados para relatório, e então
     * utiliza o JasperReports para compilar e exportar um relatório
     * para o caminho especificado.
     *
     * @param caminho O caminho completo onde o arquivo PDF do relatório será salvo
     * @throws JRException Caso ocorra algum erro durante o processo de geração do relatório
     */
    public void gerarRelatorio(String caminho) throws JRException {
        // Recupera todos os pedidos do banco de dados
        List<Pedido> pedidos = pedidoRepository.findAll();

        // Converte os pedidos para DTOs específicos para o relatório
        List<RelatorioPedidoDTO> escanor = pedidos.stream().map(RelatorioPedidoDTO::new)
                .collect(Collectors.toList());

        // Cria a fonte de dados para o relatório a partir da coleção de DTOs
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(escanor);

        // Define os parâmetros que serão passados para o relatório
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("titulo", "Relatórios de Pedidos");

        // Compila o template do relatório
        JasperReport jasperReport = JasperCompileManager
                .compileReport(getClass().getResourceAsStream("/relatorios/relatorio_pedidos.jrxml"));

        // Preenche o relatório com os dados e parâmetros
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);

        // Exporta o relatório preenchido para arquivo PDF no caminho especificado
        JasperExportManager.exportReportToPdfFile(jasperPrint, caminho);
    }
}