<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>
                    <b>
                        <xsl:value-of select="StudentScores/College"/>
                    </b>
                </h2>

                <p>
                    <table border="1">
                        <thead>
                            <tr>
                                <td>First Name</td>
                                <td>Last Name</td>
                                <td>Student Score</td>
                                <td>Student Grade</td>
                            </tr>
                        </thead>
                        <tbody>
                            <xsl:for-each select="StudentScores/Student">
                                <xsl:sort order="descending" data-type="number" select="@id"/>
                                <tr>
                                    <td>
                                        <xsl:value-of select="FirstName"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="LastName"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="Score"/>
                                    </td>
                                    <td>
                                        <xsl:choose>
                                            <xsl:when test="Score>=90">
                                                A
                                            </xsl:when>
                                            <xsl:when test="Score>=80">
                                                B
                                            </xsl:when>
                                            <xsl:otherwise>
                                                C
                                            </xsl:otherwise>
                                        </xsl:choose>
                                    </td>
                                </tr>
                            </xsl:for-each>
                        </tbody>
                    </table>
                </p>

            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>