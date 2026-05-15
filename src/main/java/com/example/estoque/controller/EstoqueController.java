package com.example.estoque.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/senai/bancada/estoque")
public class EstoqueController {

    /*
        Armazena o último dado recebido.
        Fica salvo enquanto a aplicação estiver rodando.
    */
    private static Map<String, Object> ultimoDado;

    /*
        Endpoint POST para receber dados.

        URL:
        /senai/bancada/estoque/estacao1

        Exemplo de payload:
        {
            "comutadorAutomatico": true
        }
    */
    @PostMapping("/{estacao}")
    public String receberDados(
            @PathVariable String estacao,
            @RequestBody Map<String, Object> payload
    ) {

    /*
        adiciona a estação no payload
    */
        payload.put("estacao", estacao);

    /*
        salva último payload recebido
    */
        ultimoDado = payload;

        return "Dado recebido com sucesso da " + estacao;
    }


    /*
        Endpoint GET para retornar o último dado recebido.

        URL:
        /senai/bancada/estoque/ultimo
    */
    @GetMapping("/ultimo")
    public Map<String, Object> exibirUltimoDado() {

        return ultimoDado;
    }
}