package com.datacoper.maven.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import se.gustavkarlsson.gwiz.Wizard;

public class JFrameWizard extends JFrame implements Wizard {
	private static final long serialVersionUID = 2818290889333414291L;

	private final JPanel panelButtons = new JPanel();
	private final JPanel panelContainer = new JPanel();
	private final JButton cancelButton = new JButton("Cancelar");
	private final JButton previousButton = new JButton("Anterior");
	private final JButton nextButton = new JButton("Próximo");
	private final JButton finishButton = new JButton("FInalizar");
	
	public JFrameWizard() {
		super();
		setupWizard();
	}

	private void setupWizard() {
		setupComponents();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		panelButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelButtons.add(cancelButton);
		panelButtons.add(previousButton);
		panelButtons.add(nextButton);
		panelButtons.add(finishButton);
		
		setLayout(new BorderLayout());
		add(panelContainer, BorderLayout.CENTER);
		add(panelButtons, BorderLayout.SOUTH);
		
		panelContainer.setLayout(new BorderLayout());
		
	}

	private void setupComponents() {
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		cancelButton.setMnemonic(KeyEvent.VK_C);
		previousButton.setMnemonic(KeyEvent.VK_P);
		nextButton.setMnemonic(KeyEvent.VK_A);
		finishButton.setMnemonic(KeyEvent.VK_F);

	}

	@Override
	public JPanel getWizardPageContainer() {
		return panelContainer;
	}

	@Override
	public AbstractButton getCancelButton() {
		return cancelButton;
	}

	@Override
	public JButton getPreviousButton() {
		return previousButton;
	}

	@Override
	public JButton getNextButton() {
		return nextButton;
	}

	@Override
	public JButton getFinishButton() {
		return finishButton;
	}
}
