    /* * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates * and open the template in the editor. */ package fatec.poo.model;

import java.time.LocalDate;
    import java.util.ArrayList;
    import java.util.List;

    /**
     * * * @author vitor
     */
    public class Consulta {

        private int codigo;
        private String data;
        private double valor;

        private Medico medico;
        private Paciente paciente;
        private List<Medicacao> medicacoes = new ArrayList<>();
        private List<Exame> exames = new ArrayList<>();

        public Consulta(int codigo, String data) {
            this.codigo = codigo;
            this.data = data;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

        public void setMedico(Medico medico) {
            this.medico = medico;
        }

        public void addMedicacoes(Medicacao m) {
            medicacoes.add(m);
        }

        public void addExame(Exame e) {
            exames.add(e);
        }

        public void setPaciente(Paciente paciente) {
            this.paciente = paciente;
        }

        public int getCodigo() {
            return codigo;
        }

        public Paciente getPaciente() {
            return paciente;
        }

        public String getData() {
            return data;
        }

        public double getValor() {
            return valor;
        }

        public Medico getMedico() {
            return medico;
        }

        public List<Medicacao> getMedicacoes() {
            return medicacoes;
        }

    public void setData(String data) {
        this.data = data;
    }

        public List<Exame> getExames() {
            return exames;
        }

        public double calcValorTotalPagar() {
            double total = valor;
            for (Exame e : exames) {
                total += e.getValor();
            }
            return total;
        }
    }
