<?xml version="1.0" encoding="UTF-8"?>
<!-- exe4j 7.0 -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="">

  <xsl:output indent="yes"/>

  <xsl:template match="@*|node()">
    <xsl:copy>
      <xsl:apply-templates select="@*|node()"/>
    </xsl:copy>
  </xsl:template>

  <xsl:template match="/exe4j/java/vmOptions/options/@version">
    <xsl:attribute name="{name()}">
      <xsl:text>"</xsl:text>
      <xsl:value-of select="."/>
      <xsl:text>*"</xsl:text>
    </xsl:attribute>
  </xsl:template>

</xsl:stylesheet>