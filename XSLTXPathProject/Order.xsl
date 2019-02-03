<?xml version="1.0" encoding="utf-8" standalone="yes"?> <!--XML declaration or prologue-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <!--xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    This is a prefix for the XSL namespace
    A namespace uniquely identifies a set of elements in an XML document-->
    <xsl:template match="/">
        <html>
            <body>
                <h2>The Below Orders are for
                    <xsl:value-of select="Order/CustomerName"/>
                </h2>
                <h3>
                    The order ID is: <xsl:value-of select="Order/@id" />
                </h3>
                <p>
                    <table border="1"> <!--style="border: 1px solid black;">-->
                        <thead>
                            <tr>
                                <td>Item ID</td>
                                <td>Item Name</td>
                                <td>Item Price</td>
                                <td>Quantity</td>
                                <td>Type of purchase</td>
                                <td>Membership Type</td>
                            </tr>
                        </thead>
                        <tbody>
                            <xsl:for-each select="Order/Item">
                                <xsl:sort select="Price" data-type="number" order="descending"/>
                                <!--Sorting the XML document by a specific column
                                By default it's in ascending order
                                We can use the order attribute to change the order-->
                                <tr>
                                    <td>
                                        <xsl:value-of select="ItemId"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="ItemName"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="Price"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="Quantity"/>
                                    </td>
                                    <xsl:choose>
                                        <xsl:when test="Quantity>5">
                                            <td>Retail Purchase</td>
                                        </xsl:when>
                                        <xsl:otherwise>
                                            <td>Wholesale purchase</td>
                                        </xsl:otherwise>
                                    </xsl:choose>
                                    <xsl:choose>
                                        <xsl:when test="Price&lt;100">
                                            <td>Silver Member</td>
                                        </xsl:when>
                                        <xsl:when test="Price>=100 and Price&lt;=600">
                                            <td>Gold Member</td>
                                        </xsl:when>
                                        <xsl:otherwise>
                                            <td>Platinum Member</td>
                                        </xsl:otherwise>
                                    </xsl:choose>
                                </tr>
                            </xsl:for-each>
                        </tbody>
                    </table>
                </p>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
        <!--When we apply the XSL stylesheet to an XML document
        the XSLT processor first loads the XML document as a node tree into memory
        and then looks for instructions to be applied to the node tree/XML elements
        in the XSL document.

        xsl:template match has as forward slash indicating the root element in the XML which
        in this case is "Order".

        The html/xml (generated structure) will go inside the xsl:template elements.
        In other words that means what should happen when the XML elements or nodes match
        what has been described in the "match" attribute, should go inside the
        xsl:template elements-->