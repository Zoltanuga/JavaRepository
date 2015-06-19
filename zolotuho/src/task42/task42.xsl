<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.it-academy.by" exclude-result-prefixes="a">
    <xsl:output method="html"/>
    <xsl:template match="/xs:pointList">
        <html>
            <body>
                <table border="6">
                    <th style="text-align:left" bgcolor="#adff00">x</th>
                    <th style="text-align:left" bgcolor="#adff00">y</th>
                    <xsl:for-each select="/xs:pointList/xs:point">
                        <tr>
                            <td width="68"><xsl:value-of select="xs:x"/><xsl:value-of select="@units"/></td>
                            <td width="68"><xsl:value-of select="xs:y"/><xsl:value-of select="@units"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>