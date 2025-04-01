package com.pokestore.PokeStore;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SessionBuilderConfigurer;

import java.nio.file.Paths;

@Configuration
public class AstraDbConfig extends AbstractCassandraConfiguration {

    @Override
    protected String getKeyspaceName() {
        return "pokemon";
    }

    @Override
    protected SessionBuilderConfigurer getSessionBuilderConfigurer() {
        return sessionBuilder -> sessionBuilder
                .withCloudSecureConnectBundle(
                        Paths.get("src/main/resources/secure-connect-pokemon.zip")
                )
                .withAuthCredentials(
                        "eDeElgGeHNDnjFXpKFmCATQH",
                        "ikIOZ_Xfpu8m+iGw-j.+T_yt3iUmwNKGurWzBlZB2eM6SXf0AzeKR_35GJ,2kPpfIybL0H3gr.B.Og43_IZ8fb70rB-Ib1QFK2,YqBSe9-IkdeMy8cYiCbxH.nB+PxGE"
                );
    }

}