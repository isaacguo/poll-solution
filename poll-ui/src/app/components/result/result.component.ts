import {Component, OnInit} from '@angular/core';
import {QuestionService} from "../../services/question.service";
import {Question} from "../../dto/question.model";

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {

  questions: Question[];

  constructor(private questionService: QuestionService) {
  }

  ngOnInit() {
    this.getData();

  }


  onRefreshButtonClicked()
  {
    this.getData();
  }
  getData() {
    this.questionService.getQuestions().subscribe(r => {
      this.questions = r;
    });
  }


  getQuestionCount(qIndex): number[] {
    let m = this.questions[qIndex].availableAnswers.map(r => {
      return r.selectedCount;
    });
    return m;
  }

  getQuestionAnswers(qIndex): string[] {
    let m = this.questions[qIndex].availableAnswers.map(r => {
      return r.answer;
    });
    return m;
  }


  public doughnutChartType: string = 'doughnut';

// events
  public chartClicked(e: any): void {
    console.log(e);
  }

  public chartHovered(e: any): void {
    console.log(e);
  }
}
