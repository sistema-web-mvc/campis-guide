# 📍 Campi's Guide (Indoor Navigation System)

> **Solução inteligente de navegação e localização interna para campi universitários e grandes espaços.**

---

## 📌 1. Visão Geral e Problema

Em complexos educacionais de grande porte como o **IFTM (Instituto Federal do Triângulo Mineiro)**, é comum que alunos (especialmente ingressantes), visitantes e servidores se sintam perdidos ao tentar localizar salas de aula, laboratórios, auditórios ou até mesmo colegas e professores.

### ❓ A Dor do Usuário
* **Orientação Deficiente:** Soluções tradicionais de GPS (como Google Maps ou Waze) não possuem mapeamento detalhado da planta interna (*indoor*) de edifícios.
* **Falta de Autonomia:** Atualmente, os usuários recorrem a pedir informações verbais a terceiros — processo ineficiente, por vezes constrangedor e propenso a orientações imprecisas.
* **Perda de Tempo:** Dificuldade para encontrar salas e pontos de interesse específicos no tempo adequado.

---

## 🎯 2. Objetivos do Projeto

### 🎯 Objetivo Principal
Desenvolver uma plataforma de navegação interna acessível e interativa que guie os usuários dentro do campus do IFTM em tempo real, fornecendo rotas precisas até salas, setores e pessoas.

### 🎯 Objetivos Específicos
- 🗺️ **Mapeamento 2D/3D & Street View:** Apresentar a planta georreferenciada do campus com transição para navegação panorâmica (*Street View* interno).
- 🚶 **Cálculo Dinâmico de Rotas:** Fornecer caminhos otimizados entre a posição atual do usuário e o destino final.
- ♿ **Acessibilidade:** Priorizar rotas adaptadas (uso de elevadores e rampas em vez de escadas) quando solicitado.
- 🔍 **Busca Integrada:** Permitir encontrar salas, banheiros, setores administrativos e pessoas no campus.

---

## 👤 3. Público-Alvo e Casos de Uso

| Público | Necessidade Principal |
| :--- | :--- |
| **Alunos Ingressantes / Veteranos** | Localizar salas de aula, laboratórios, blocos e colegas dentro do campus. |
| **Visitantes / Comunidade** | Guiar-se de forma autônoma até eventos, auditórios e secretarias. |
| **Pessoas com Mobilidade Reduzida** | Encontrar rotas acessíveis com rampas e elevadores desobstruídos. |

---

## 🛠️ 4. Requisitos do Sistema

### 📋 Requisitos Funcionais (RF)

- [ ] **RF-01 (Mapa Interativo):** O aplicativo deve exibir a planta digitalizada do campus com controles de zoom, pan e alternância entre andares.
- [ ] **RF-02 (Modo Street View):** Ao ampliar o mapa até um determinado nível de zoom, o app deve transicionar automaticamente para a visão imersiva (Street View).
- [ ] **RF-03 (Pesquisa de Pontos de Interesse):** O sistema deve permitir a busca por código de sala, nome de setor, banheiros ou nome de pessoas.
- [ ] **RF-04 (Tracejo de Rotas):** O aplicativo deve calcular e desenhar a rota ideal no mapa a partir do ponto atual do usuário até o destino selecionado.
- [ ] **RF-05 (Rotas de Acessibilidade):** O usuário deve poder filtrar rotas para priorizar caminhos acessíveis (elevadores e rampas).
- [ ] **RF-06 (Localização em Tempo Real):** O sistema deve identificar o posicionamento interno (*indoor positioning*) do dispositivo com precisão métrica.

### 📋 Requisitos Não-Funcionais (RNF)

- [ ] **RNF-01 (Precisão):** O posicionamento indoor deve garantir uma margem de precisão entre 1 e 3 metros.
- [ ] **RNF-02 (Desempenho):** O carregamento da planta e o cálculo da rota devem ocorrer em no máximo 2 segundos.
- [ ] **RNF-03 (Usabilidade):** A interface deve permitir iniciar a navegação em menos de 3 toques/interações.
- [ ] **RNF-04 (Compatibilidade):** A solução deve ser acessível via navegadores web (WebApp/QR Code) e/ou aplicativo móvel leve (Android/iOS).
- [ ] **RNF-05 (Escalabilidade):** A arquitetura da malha de rotas deve permitir o fácil cadastramento de novos prédios ou andares.

---

## ⚙️ 5. Tecnologias de Navegação Indoor (Estudo Técnico)

Para substituir a ausência de sinal GPS no interior dos edifícios, a solução adota uma abordagem híbrida:

1. **Digitalização & Georreferenciamento:** Conversão da planta baixa (CAD/BIM) para formatos vetoriais web interativos (GeoJSON / IMDF).
2. **Malha de Rotas (Graph Routing):** Grafo de rotas invisíveis interligando corredores, portas, escadas e elevadores.
3. **Posicionamento Interno (Indoor Positioning):**
   * **Beacons BLE (Bluetooth Low Energy):** Dispositivos transmissores fixados no teto/paredes para triagulação precisa via Bluetooth.
   * **Wi-Fi Fingerprinting:** Leitura da variação e intensidade do sinal dos roteadores já existentes no campus.

---

## 👥 6. Equipe de Desenvolvimento

* **Laila Cristina Ribeiro Alves**
* **Matheus**
* **Lázaro**
* **Gabriel**
* **Victor**

---

*Projeto desenvolvido com foco na facilidade de locomoção e acessibilidade no campus IFTM.*