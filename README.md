# brasil-transparente-processor

Módulo responsável por ler e salvar no banco arquivos de gastos de todas as partes da União previamente organizados no formato csv.

## 📦 Instalação e Configuração

### Pré-requisitos
- Java 21+
- MySQL
- Git

### Passos
1. Clone o repositório:
   ```bash
   git clone https://github.com/PoxDie/brasil-transparente-processor
   ```
2. Crie a estrutura do banco no MySQL utilizando a query no arquivo table_setup.sql.
3. Copie os arquivos de gastos da União do Drive (URL) para a pasta do projeto.
4. Certifique-se de que os paths no projeto estão apontando para o local correto dos arquivos.
5. Suba a aplicação utilizando o SpringBoot, rodando a classe BrasilTransparenteProcessorApplication.
6. Chame o Controller utilizando o POST ( /processYear={ano} ) e passando o ano de 2024.
7. Se tudo estiver correto, a aplicação irá ler todos os arquivos e salvar no banco local todos os dados.

## 🤝 Como Contribuir
- 📌 **Participe no Discord**: A melhor forma de ajudar na contribuição do projeto é estar alinhado com o que está sendo discutido no nosso Discord:
https://discord.gg/sQbf3bSzt4
- 🐛 **Issues existentes**: Dentro do repositório no GitHub mantemos uma lista de Issues que devem trabalhadas, geralmente alocadas dentro de projetos. É possível acompanhar o andamento das entregas por lá.
- 🛠️ **Reportar problemas/sugestões**: Para reportar bugs e sugerir novas melhorias, por favor, entre em contato com a gente no nosso Discord.

## ⚖️ Licença
[![AGPL-3.0](https://img.shields.io/badge/License-AGPL_v3-blue.svg)](https://www.gnu.org/licenses/agpl-3.0)

Este projeto está licenciado sob os termos da **GNU Affero General Public License v3.0** (AGPL-3.0).
- ✅ Liberdade para usar e modificar.
- 🔁 Exige compartilhamento das modificações.
- 🌍 Código-fonte deve ser disponibilizado para usuários.

Consulte o arquivo [LICENSE](LICENSE) para o texto completo da licença.