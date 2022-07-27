package br.com.zup.edu.commerce.notasfiscais.util;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class XMLUtil {

    @Autowired
    Jackson2ObjectMapperBuilder mapperBuilder;

    public File converteObjetoParaArquivoXML(Object objeto, String nomeArquivo) throws Exception {
        XmlMapper xmlMapper = mapperBuilder.createXmlMapper(true).build();

        xmlMapper.writeValue(new File(nomeArquivo), objeto);

        File arquivo = new File(nomeArquivo);

        return arquivo;
    }

}
