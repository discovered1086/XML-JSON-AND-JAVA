<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>
                    <b>Order ID:</b>
                    <xsl:value-of select="Order/@id"/>
                </h2>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="CustomerName">  <!--This can be an XPATH expression or just the name of
    the XML element we're targeting. Once the XSLT processor encounters the element name "CustomerName"
    it'll process the instructions we put here-->
        <h4>Customer Name:
            <xsl:value-of select="."/>
        </h4> <!--. is an XPATH expression that displays the current
        node's value-->
    </xsl:template>

    <xsl:template match="Item"><!--This can be an XPATH expression or just the name of
    the XML element we're targeting. Every time the XSLT processor encounters the element name "Item"
    it'll process the instructions we put here-->
        <h4>
            <xsl:value-of select="ItemName"/> costs $<xsl:value-of select="Price"/>
        </h4>
    </xsl:template>


</xsl:stylesheet>