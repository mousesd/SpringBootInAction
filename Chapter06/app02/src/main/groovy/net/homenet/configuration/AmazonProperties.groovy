package net.homenet.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("amazon")
class AmazonProperties {
    String associateId

    def getAssociateId() {
        return associateId
    }
}
