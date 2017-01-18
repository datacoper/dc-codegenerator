# dcgeneratecode
Gerador de códigos Datacoper

## Utilização
Para rodar o plugin, utilize o seguinte comando no diretório onde existe um *pom* agregador (*parent pom*). Como, por exemplo, na pasta `Faturamento-Parent`.
> `com.datacoper.maven.plugin:dcgeneratecode-maven-plugin:<goal>`

Onde `<goal>` pode ser um dos seguintes:
- `scaffold` : Cria uma entidade nova e toda a stack de classes, do modelo ao REST.

# Roadmap
- [x] **v1.2.0** - Gerar o código de um grupo específico (common, server, rest).
- [ ] **v1.3.0** - Gerar código com classes que estão no classpath dos projetos.
