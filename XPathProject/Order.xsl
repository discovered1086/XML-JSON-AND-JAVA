<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h1>
                    Order Details:
                </h1>
                <xsl:apply-templates/>
                <!--The above line is very crucial. This is what makes sure other templates
                are processed and applied in this position-->
            </body>
        </html>
    </xsl:template>

    <xsl:template match="CustomerName">
        <h3>Customer Name:
            <xsl:value-of select="."/>
        </h3>
        <!--"." in XPath represents the current node-->
        <!--Whatever we write inside the xsl:template are nothing but instructions
        when the XSLT processor encounters any element named Customer Name-->
    </xsl:template>

</xsl:stylesheet>