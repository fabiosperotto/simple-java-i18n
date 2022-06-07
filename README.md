
# simple-java-i18n

Exemplo de implementação mínima de internacionalização de projetos em Java com Maven. Seguindo as guidelines de [Java Internationalization Support - Oracle Tech Notes](https://docs.oracle.com/javase/8/docs/technotes/guides/intl/index.html). 


## Configuração

- Verifique as configurações em pom.xml para o build do .jar;
- No diretório /idiomas, constam arquivos exemplos de traduções a serem utilizadas;
- Ao gerar o pacote.jar com o build do Maven, copie o pacote.jar gerado em /target e crie um diretório separado (/sistema por exemplo). Neste novo diretório inclua o pacote.jar e o diretório de /idiomas.

## Execução
- A partir da configuração anterior, execute o pacote.jar via linha de comando enviando como parâmetro os valores para o idioma e país, exemplos:
```
```console
foo@bar:~$ java -jar pacote.jar pt BR
Nome
foo@bar:~$ java -jar pacote.jar en US
Name
```
- Inclua novos arquivos de idiomas seguindo o padrão proposto. Altere a linha de comando de acordo. Poderá gerar um atalho para o paocte.jar repassando como parâmetro aqueles valores de idioma e país.