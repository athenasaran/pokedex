# 🌟 Pokedex

Este é um projeto desenvolvido em Kotlin utilizando as melhores práticas de desenvolvimento Android e ferramentas modernas.

---

## 🚀 Tecnologias Utilizadas

### 🔹 **Linguagem & Plataforma**
- **Kotlin** – Linguagem oficial para Android.
- **Coroutines** – Para programação assíncrona e concorrência.
- **Kotlin Serialization** – Para parsing de dados JSON de forma simples.

---

### 🔹 **Armazenamento de Dados**
- **Room** – Banco de dados local e persistência.

---

### 🔹 **Arquitetura & Estado**
- **Clean Architecture** – Organização do código focada em responsabilidade única e desacoplamento.
- **MVI** – Padrão para gerenciamento de estados imutáveis.
- **Unidirectional Data Flow (UDF)** – Fluxo unidirecional para gerenciar o ciclo de dados entre UI e lógica.
- **Flow** – Gerenciamento de estados reativos e streams.
- **StateFlow** – Fluxo de estado reativo para camadas de UI.
- **Single Source of Truth** – O estado de cada dado é centralizado e sincronizado com as camadas de dados e UI.

---

### 🔹 **UI e Animações**
- **Jetpack Compose** – Framework moderno para interfaces declarativas.
- **Compose Animations** – Animações fluídas e performáticas.
- **Material Design** – Componentes modernos para interface do usuário.

---

### 🔹 **Gerenciamento de Navegação**
- **Navigation Compose** – Navegação declarativa entre telas.

---

### 🔹 **Injeção de Dependência**
- **Hilt** – Framework eficiente para injeção de dependências.

---

### 🔹 **Imagem e Recursos**
- **Coil** – Framework leve para carregamento de imagens.

---

### 🔹 **Consumo de API**
- **Retrofit** – Cliente HTTP para comunicação com APIs.
- **Kotlin Serialization** – Para deserialização de respostas JSON.

---

### 🔹 **Gerenciamento de Build**
- **Gradle Convention Plugin** – Automação de builds e configuração compartilhada.

---

### 🔹 **Testes**
- **JUnit** – Framework para testes unitários.
- **Mockk** – Biblioteca para mockar dependências durante testes.
- **Turbine** – Ferramenta para testar objetos `Flow` com mais facilidade.

---

## 📐 Modularização

Este projeto segue uma abordagem modularizada para facilitar a escalabilidade, manutenibilidade e organização do código. Os módulos estão divididos nas seguintes camadas:

### 🔹 **Módulos Principais**
1. **Network**: Contém classes para configuração e consumo de APIs usando Retrofit e Kotlin Serialization.
2. **Data**: Implementação da camada de repositórios, persistência local (Room) e acesso remoto (APIs).
3. **Domain**: Casos de uso, entidades e lógica de negócio centralizada.
4. **Feature**: Features independentes organizadas por funcionalidade (UI e lógica específicas).
5. **Design System**: Componentes de UI reutilizáveis e estilos baseando-se no Material Design, implementados com Jetpack Compose.
6. **Testing**: Módulo dedicado para testes unitários e de instrumentação, utilizando JUnit, Mockk e Espresso.

---

## 🌐 **Fluxo de Dados**
Este projeto implementa o padrão **UDF (Unidirectional Data Flow)** e **Single Source of Truth** para garantir que os dados trafeguem em um único fluxo entre camadas. Aqui está como funciona:
1. A **UI** dispara eventos para os **ViewModels**.
2. Os **ViewModels** definem o estado baseando-se nas respostas da camada **Domain** e atualizam os estados de maneira observável (StateFlow).
3. O banco de dados local ou API serve como fonte única e centralizada de dados (**Single Source of Truth**), mantendo a consistência em tempo real.

---

## 📂 **Estrutura do Projeto**

O projeto segue a abordagem de **Clean Architecture**, organizando as responsabilidades em três camadas principais:
1. **Data**: Camada de acesso a dados (APIs, Banco de dados, etc.).  
2. **Domain**: Camada de regras de negócio e casos de uso.  
3. **Presentation**: Camada de interface com o usuário (UI).  

---

## 🌟 Diferenciais
- 💡 Implementação de práticas modernas como **UDF** e **Single Source of Truth**.
- 🔌 Configuração modularizada com plugins gerados no Gradle.
- 🎨 UI fluida e responsiva utilizando Compose e Material Design.
- ✅ Testes robustos para garantir alta qualidade.

---

Sinta-se à vontade para explorar e contribuir! 😊
